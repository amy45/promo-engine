import com.example.promo.engine.enums.SKUTYPE;
import com.example.promo.engine.models.SKU;
import com.example.promo.engine.services.PromotionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Amit Jethwani
 */
public class PromotionEngineTest {


    PromotionService promotionService;
    List<SKU> skuList;
    SKU skuA;
    SKU skuB;
    SKU skuC;
    SKU skuD;

    @Before
    public void init() {
        promotionService = new PromotionService();
        skuA = new SKU(SKUTYPE.A);
        skuB = new SKU(SKUTYPE.B);
        skuC = new SKU(SKUTYPE.C);
        skuD = new SKU(SKUTYPE.D);
    }


    @Test
    public void when_sku_is_A_should_return() {
        Assert.assertEquals(50, promotionService.getPriceByType(SKUTYPE.A));
    }

    @Test
    public void when_sku_is_B_should_return() {
        Assert.assertEquals(30, promotionService.getPriceByType(SKUTYPE.B));
    }

    @Test
    public void when_sku_is_C_should_return() {
        Assert.assertEquals(20, promotionService.getPriceByType(SKUTYPE.C));
    }

    @Test
    public void when_sku_is_D_should_return() {
        Assert.assertEquals(15, promotionService.getPriceByType(SKUTYPE.D));
    }


    @Test
    public void when_sku_are_C_D_should_return_promo_price() {
        skuList = Arrays.asList(skuC, skuD);
        Assert.assertEquals(20, promotionService.getTotalPrice(skuList));
    }
}
