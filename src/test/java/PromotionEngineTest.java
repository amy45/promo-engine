import com.example.promo.engine.enums.SKUTYPE;
import com.example.promo.engine.services.PromotionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Amit Jethwani
 */
public class PromotionEngineTest {


    PromotionService promotionService;

    @Before
    public void init() {
        promotionService = new PromotionService();
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
}
