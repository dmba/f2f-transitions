package me.dmba.f2ftransitions.data

import java.util.*

/**
 * Created by dmba on 6/10/18.
 */
object DataProvider {

    val data: List<DataItem> by lazy {
        listOf(

            DataItem(
                "any",
                "Ulf",
                "https://c1.staticflickr.com/1/188/417924629_6832e79c98_z.jpg?zz=1"
            ),

            DataItem(
                "any",
                "Penguin",
                "https://c1.staticflickr.com/9/8616/16237154608_c5489cae31_z.jpg"
            ),

            DataItem(
                "any",
                "Eagle",
                "https://c1.staticflickr.com/5/4010/4210875342_7cb06a9b62_z.jpg?zz=1"
            ),

            DataItem(
                "any",
                "Rabbit",
                "https://c2.staticflickr.com/4/3285/2819978026_175072995a_z.jpg?zz=1"
            ),

            DataItem(
                "any",
                "Dolphin",
                "https://c1.staticflickr.com/8/7619/16124006043_60bc4d8ca5_z.jpg"
            ),

            DataItem(
                "any",
                "Snake",
                "https://c1.staticflickr.com/9/8796/17158681740_a6caa5099f_z.jpg"
            ),

            DataItem(
                "any",
                "Tarasiuta",
                "https://c1.staticflickr.com/4/3852/14729534910_62b338dd72_z.jpg"
            ),

            DataItem(
                "any",
                "Rhino",
                "https://c1.staticflickr.com/1/335/18040640224_f56f05f8dc_z.jpg"
            ),

            DataItem(
                "any",
                "Leopard",
                "https://c1.staticflickr.com/9/8678/16645189230_b0e96e7af9_z.jpg"
            ),

            DataItem(
                "any",
                "Hippo",
                "https://c2.staticflickr.com/4/3774/9377370000_6a57d1cfec_z.jpg"
            )

        ).map(::toSameWithRandomId)
    }

    private fun toSameWithRandomId(item: DataItem): DataItem = item.copy(id = UUID.randomUUID().toString())

}
