package CoreJava.JavaUtil.collections.Map;

import CoreJava.JavaUtil.collections.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
}

interface ProductLookUpTable {
    Product lookupById(int id);

    void addProduct(Product product);

    void clear();
}

class NativeProductLookupTable implements ProductLookUpTable
{
    private Map<Integer,Product> IdToProduct = new HashMap<>();
    @Override
    public void addProduct(Product product) {
        IdToProduct.put(product.getId(), product);

        Set<Integer> integers = IdToProduct.keySet();

    }

    @Override
    public Product lookupById(int id) {
        return IdToProduct.get(id);
    }

    @Override
    public void clear() {
        IdToProduct.clear();
    }
}
