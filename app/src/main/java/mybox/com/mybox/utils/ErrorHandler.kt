package mybox.com.mybox.utils

/**
 * Created by Sergbek on 12.12.2016.
 */
object ErrorHandler {

//    fun onError(_view: DialogView, _throwable: Throwable) {
//        Logger.e(_throwable)
//        if (_throwable is TimeoutException) {
//            _view.showErrorDialog(R.string.error_bad_network_connection, null)
//
//            return
//        }
//        if (_throwable is RetrofitException) {
//            when (_throwable.kind) {
//
//                HTTP -> {
//                    when (_throwable.response.code()) {
//                        455 -> {
//                            _view.showErrorDialog(R.string.error_wrong_user, null)
//                            return
//                        }
//                        456 -> {
//                            _view.showErrorDialog(R.string.auth_error, null)
//                            return
//                        }
//                        458 -> {
//                            _view.showErrorDialog(R.string.user_already_exists, null)
//                            return
//                        }
//                        401 -> {
//                            _view.show401Dialog()
//                            return
//                        }
//                        404 -> {
//                            _view.showErrorDialog(R.string.error_server_not_responding, null)
//                            return
//                        }
//                    }
//                    try {
//                        val bodyAs = _throwable.getErrorBodyAs(RetrofitErrorResponse::class.java)
//                        _view.showErrorDialog(bodyAs.error[0], null)
//                    } catch (_e: Exception) {
//                        _view.showErrorDialog(_e.message, null)
//                    }
//                }
//                else -> _view.showErrorDialog(R.string.error_bad_network_connection, null)
//            }
//        } else {
//            _view.showErrorDialog(_throwable.message, null)
//        }
//    }
//
//    fun isNetworkError(_throwable: Throwable): Boolean {
//        if (_throwable is TimeoutException || _throwable is ConnectException) {
//            return true
//        }
//        if (_throwable is HttpException) {
//            when (_throwable.code()) {
//                400 -> return false
//                401 -> return false
//                404 -> return true
//                else -> return false
//            }
//        }
//        return false
//    }
//
//    fun isUnauthorized(_throwable: Throwable): Boolean {
//        if (_throwable is HttpException) {
//            when (_throwable.code()) {
//                401 -> return true
//                else -> return false
//            }
//        }
//        return false
//
//    }
//
//    fun onGoogleError(_dialogView: DialogView, _throwable: Throwable) {
//        Logger.e(_throwable)
//
//        if (_throwable is GoogleAPIConnectionException) {
//            _dialogView.showErrorDialog("Please update your current version of Google services", null)
//        } else {
//            onError(_dialogView, _throwable)
//        }
//    }
}