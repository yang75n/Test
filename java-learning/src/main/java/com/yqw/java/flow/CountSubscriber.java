package com.yqw.java.flow;

import java.util.concurrent.Flow;

class CountSubscriber implements Flow.Subscriber<Integer> {
    private Flow.Subscription subscription;
    private int count;

    public CountSubscriber(int count) {
        this.count = count;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        /* 订阅时请求第一组 */
        int requestCount = Math.min(10, count);
        count -= requestCount;
        subscription.request(requestCount);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("onNext:" + item);
        if ((item + 1) % 10 == 0 && count > 0) { //每组请求到后请求下一组
            int requestCount = Math.min(10, count);
            count -= requestCount;
            subscription.request(requestCount);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError:" + throwable);
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete...");
    }
}