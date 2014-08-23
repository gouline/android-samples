package net.gouline.kotlindemo.app

import android.app.Fragment
import android.os.Bundle
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import net.gouline.kotlindemo.R
import android.widget.TextView
import rx.subscriptions.Subscriptions
import android.os.SystemClock
import rx.schedulers.Schedulers

/**
 * Details view for a Wi-Fi base station.
 *
 * @author Mike Gouline
 */
open class WifiDetailFragment() : Fragment() {
    class object {
        fun newInstance(): WifiDetailFragment {
            return WifiDetailFragment()
        }
    }

    private var contentTextView: TextView? = null

    private var strings: Observable<String>? = null
    private var subscription = Subscriptions.empty()

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Fragment>.onCreate(savedInstanceState)

        strings = Observable.range(0, 10)
                ?.map({ num ->
                    num.toString()
                })
                ?.doOnNext { SystemClock.sleep(1000) }
                ?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.cache()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wifi_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super<Fragment>.onViewCreated(view, savedInstanceState)

        contentTextView = view?.findViewById(R.id.txt_content) as TextView
        contentTextView?.setText(R.string.prompt_loading)

        subscription = strings?.subscribe({ txt ->
            contentTextView?.setText(txt)
        })
    }
}