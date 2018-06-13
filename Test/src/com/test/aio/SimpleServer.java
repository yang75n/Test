package com.test.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class SimpleServer {

	public SimpleServer(int port) throws IOException {
		final AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel.open()
				.bind(new InetSocketAddress(port));

		listener.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
			public void completed(AsynchronousSocketChannel ch, Void att) {
				// 接受下一个连接
				listener.accept(null, this);

				// 处理当前连接
				handle(ch);
			}

			public void failed(Throwable exc, Void att) {

			}
		});

	}

	private void handle(AsynchronousSocketChannel ch) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(32);
		try {
			ch.read(byteBuffer).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byteBuffer.flip();
		System.out.println("server received:" + byteBuffer.get());
		// Do something
	}

	public static void main(String[] args) {
		try {
			SimpleServer server = new SimpleServer(7788);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
