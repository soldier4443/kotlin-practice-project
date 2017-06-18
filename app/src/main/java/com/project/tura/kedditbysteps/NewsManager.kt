package com.project.tura.kedditbysteps

import io.reactivex.Observable

/**
 * Created by soldi on 2017-06-17.
 */

class NewsManager() {

    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create { subscriber ->

            var news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        "url"
                ))
            }

            subscriber.onNext(news)
            subscriber.onComplete()
        }
    }
}