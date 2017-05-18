package tansactiontest;

import com.xiangyang.AO.ProductAO;
import com.xiangyang.form.product.AddProductForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiangyang on 2017/5/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testconfig/applicationContext-core.xml"})
public class TransactionTest {
    @Autowired
    ProductAO productAO;

    @Test
    public void transTest(){
        AddProductForm addProductForm = new AddProductForm();
        addProductForm.setProductDesc("sdfasdfasdf");
        addProductForm.setProductName("afdadfadfa");
        addProductForm.setTeamId(123l);
        productAO.addProduct(addProductForm);
    }


}
