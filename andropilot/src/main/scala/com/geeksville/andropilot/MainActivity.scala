package com.geeksville.andropilot

import android.app.Activity
import _root_.android.os.Bundle
import android.content.Intent

class MainActivity extends Activity with TypedActivity {
  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)

    findView(TR.textview).setText("hello, world!")

    startService(new Intent(this, classOf[AndropilotService]))
  }
}
