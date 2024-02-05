import mo.inc.eh.products.domian.entity.Product

data class ProductResponseItem(
    val product: Product,
    val productMerchants: List<ProductMerchant>
)