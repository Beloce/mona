package AOtest;

import com.xiangyang.AO.DepartmentAO;
import com.xiangyang.model.DepartmentDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by xiangyang on 17/3/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testconfig/applicationContext-core.xml"})
public class DepartmentAOTest {
    @Autowired
    DepartmentAO departmentAO;

    @Test
    public void queryDepartmentList(){
        Long departmentId = 82l;
        List<DepartmentDO> departmentDOs = departmentAO.querySonDepartmentListById(departmentId);
        System.out.println(departmentDOs.toString());
    }
}
