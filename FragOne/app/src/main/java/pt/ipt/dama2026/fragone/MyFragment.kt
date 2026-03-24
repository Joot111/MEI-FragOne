package pt.ipt.dama2026.fragone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_TEXTO_TEXT_VIEW = "param1"
private const val ARG_TEXTO_BOTAO = "param2"

private const val ARG_NUM_FRAGMENTO = "param3"

/**
 * A simple [Fragment] subclass.
 * Use the [MyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    // texto mostrar na TextView do Fragmento
    private var txtTextView: String? = null
    // texto mostrar no Botão do Fragmento
    private var txtButton: String? = null

    // var auxiliar para instanciar com o número do fragmento a criar
    private var numFragmento: Byte? = null

    /**
     * Cria o fragmento com um texto e um botão
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            txtTextView = it.getString(ARG_TEXTO_TEXT_VIEW)
            txtButton = it.getString(ARG_TEXTO_BOTAO)
            numFragmento = it.getByte(ARG_NUM_FRAGMENTO)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_my, container, false)

        // var auxiliar para instanciar os dados do fragmento (TextView)
        val aux_textView: androidx.appcompat.widget.AppCompatTextView = view.findViewById(R.id.textFragment)
        aux_textView.text = txtTextView

        // var auxiliar para instanciar os dados do fragmento (Button)
        val aux_button: androidx.appcompat.widget.AppCompatButton = view.findViewById(R.id.bttFragment)
        aux_button.text = txtButton

        // Mostrar par/impar apenas quando o utilizador clicar no botao.
        aux_button.setOnClickListener {
            val numero = numFragmento?.toInt() ?: 0
            if (numero % 2 == 0) {
                Toast.makeText(requireContext(), getString(R.string.msgPar), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), getString(R.string.msgImpar), Toast.LENGTH_SHORT).show()
            }
        }
        
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_my, container, false)

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param txtLabel Parameter 1.
         * @param txtBotao Parameter 2.
         * @numFrag numero do fragmento a criar
         * @return devolve uma nova intância do fragment MyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(txtLabel: String, txtBotao: String, numFrag: Byte) =
            MyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEXTO_TEXT_VIEW, txtLabel)
                    putString(ARG_TEXTO_BOTAO, txtBotao)
                    putByte(ARG_NUM_FRAGMENTO, numFrag)
                }
            }
    }
}