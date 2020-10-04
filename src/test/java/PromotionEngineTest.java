import com.example.promo.engine.enums.SKUTYPE;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Amit Jethwani
 */
public class PromotionEngineTest {



    @Test
    public void when_sku_is_A_should_return(){
        Assert.assertEquals(50,skuService.getPriceByType(SKUTYPE.A));
    }

    @Test
    public void when_sku_is_B_should_return(){
        Assert.assertEquals(30,skuService.getPriceByType(SKUTYPE.B));
    }

    @Test
    public void when_sku_is_C_should_return(){
        Assert.assertEquals(20,skuService.getPriceByType(SKUTYPE.C));
    }

    @Test
    public void when_sku_is_D_should_return(){
        Assert.assertEquals(15,skuService.getPriceByType(SKUTYPE.D));
    }
}
