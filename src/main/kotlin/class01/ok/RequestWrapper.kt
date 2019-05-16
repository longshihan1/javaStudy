//package class01.ok
//
//import io.reactivex.BackpressureStrategy
//import io.reactivex.Flowable
//import io.reactivex.schedulers.Schedulers
//import okhttp3.OkHttpClient
//import okhttp3.Request
//import okhttp3.RequestBody
//import okhttp3.Response
//import java.util.concurrent.TimeUnit
//
//
//class RequestWrapper {
//
//    var url:String? = null
//
//    var method:String? = null
//
//    var body: RequestBody? = null
//
//    var timeout:Long = 10
//
//    internal var success: (String) -> Unit = { }
//    internal var fail: (Throwable) -> Unit = {}
//
//    fun onSuccess(onSuccess: (String) -> Unit) {
//        success = onSuccess
//    }
//
//    fun onFail(onError: (Throwable) -> Unit) {
//        fail = onError
//    }
//}
//
//fun http(init: RequestWrapper.() -> Unit) {
//    val wrap = RequestWrapper()
//
//    wrap.init()
//
//    executeForResult(wrap)
//}
//
//private fun executeForResult(wrap:RequestWrapper) {
//
//    Flowable.create<Response>({
//        e -> e.onNext(onExecute(wrap)!!)
//    }, BackpressureStrategy.BUFFER)
//            .subscribeOn(Schedulers.io())
//            .subscribe(
//                    { resp ->
//                        wrap.success(resp.body()!!.string())
//                    },
//
//                    { e -> wrap.fail(e) })
//}
//
//private fun onExecute(wrap:RequestWrapper): Response? {
//
//    var req:Request? = null
//    when(wrap.method) {
//
//        "get","Get","GET" -> req =Request.Builder().url(wrap.url).build()
//        "post","Post","POST" -> req = Request.Builder().url(wrap.url).post(wrap.body).build()
//        "put","Put","PUT" -> req = Request.Builder().url(wrap.url).put(wrap.body).build()
//        "delete","Delete","DELETE" -> req = Request.Builder().url(wrap.url).delete(wrap.body).build()
//    }
//
//    val http = OkHttpClient.Builder().connectTimeout(wrap.timeout, TimeUnit.SECONDS).build()
//    return http.newCall(req).execute()
//}
