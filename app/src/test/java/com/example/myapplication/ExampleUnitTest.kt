package com.example.myapplication

import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.junit.Assert.*
import org.junit.Test
import java.math.BigDecimal
import java.math.BigInteger
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.ceil


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() = runTest{
        assertEquals(4, 2 + 2)
//
//            val job = flow {
//                this.emit(1)
//                this.emit(2)
//                kotlinx.coroutines.delay(3000)
//                this.emit(3)
//            }.map {  }
//                .onEach { value -> println("$value ***") }
//                .onCompletion { cause -> println(cause) }
//                .catch { cause -> println("Exception: $cause") }
//                .launchIn(this)
//
//        job.cancel()

        Completable.timer(3,TimeUnit.SECONDS)
            .subscribe { println("dddd") }


        Thread.sleep(200000)

    }



}


