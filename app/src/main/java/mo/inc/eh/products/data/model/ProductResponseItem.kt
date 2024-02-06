package mo.inc.eh.products.data.model

import mo.inc.eh.products.domian.entity.Product

data class ProductResponseItem(
    val Product: Product,
    val ProductMerchants: List<ProductMerchant>
)