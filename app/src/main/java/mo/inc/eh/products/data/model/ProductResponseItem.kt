package mo.inc.eh.products.data.model

data class ProductResponseItem(
    val Product: Product,
    val ProductMerchants: List<ProductMerchant>
)