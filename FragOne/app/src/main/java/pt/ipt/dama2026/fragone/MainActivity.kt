package pt.ipt.dama2026.fragone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // variáveis para manipular os fragmentos
    private lateinit var f1 : MyFragment
    private lateinit var f2 : MyFragment
    private lateinit var f3 : MyFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // instancia os fragmentos
        f1 = MyFragment.newInstance(getString(R.string.textFragment1),
                                    getString(R.string.bttFragment1), numFrag = 1)
        f2 = MyFragment.newInstance(getString(R.string.textFragment2),
                                    getString(R.string.bttFragment2), numFrag = 2)
        f3 = MyFragment.newInstance(getString(R.string.textFragment3),
                                    getString(R.string.bttFragment3), numFrag = 3)

        // injetar estes três fragmentos no layout da atividade, na interface gráfica
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment1, f1)
        fragmentTransaction.add(R.id.fragment2, f2)
        fragmentTransaction.add(R.id.fragment3, f3)
        fragmentTransaction.commit()
    }
}