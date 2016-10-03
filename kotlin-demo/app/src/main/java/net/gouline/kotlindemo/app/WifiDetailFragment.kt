package net.gouline.kotlindemo.app

import android.app.Fragment
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_wifi_detail.*
import net.gouline.kotlindemo.R
import net.gouline.kotlindemo.model.WifiStation
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

/**
 * Details view for a Wi-Fi base station.
 */
open class WifiDetailFragment() : Fragment() {

    companion object {
        private const val ARG_STATION = "station"

        fun newInstance(station: WifiStation): WifiDetailFragment {
            val f = WifiDetailFragment()
            f.arguments = Bundle()
            f.arguments.putSerializable(ARG_STATION, station)
            return f
        }
    }

    private var contentTextView: TextView? = null

    private var strings: Observable<String>? = null
    private var subscription = Subscriptions.empty()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        strings = Observable.range(0, 10)
                .map { it.toString() }
                .doOnNext { SystemClock.sleep(1000) }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .cache()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wifi_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt_content.setText(R.string.prompt_loading)

        subscription = strings?.subscribe { text ->
            contentTextView?.text = text
        }
    }

    override fun onDestroyView() {
        subscription?.unsubscribe()

        super.onDestroyView()
    }
}