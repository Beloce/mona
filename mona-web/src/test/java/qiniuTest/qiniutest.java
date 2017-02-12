package qiniuTest;

import com.xiangyang.BizResult;
import com.xiangyang.manager.impl.ImageManagerImpl;

import java.io.File;
import java.io.IOException;

/**
 * Created by peiji on 2017/2/12.
 */
public class qiniutest {

    public static void main(String[] args) throws IOException {
        ImageManagerImpl imageManager = new ImageManagerImpl();
        File file = new File("D:/047A0488.jpg");
        BizResult bizResult = imageManager.upload(file);
        System.out.println(bizResult.getResult());
    }
}
