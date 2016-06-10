package java1;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by lz on 2016/6/3.
 */
public class TestPageHelper {
    @Test
    public void testPageHelper(){
        //创建spring容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从spring容器中获得Mapper的代理对象
        TbItemMapper mapper=applicationContext.getBean(TbItemMapper.class);
        TbItemExample example=new TbItemExample();
        PageHelper.startPage(1,10);
        List<TbItem> list=mapper.selectByExample(example);
        for (TbItem tbItem : list){
            System.out.println(tbItem.getTitle());
        }
        //取我们的总数量.从对象中取分页信息
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        long total=pageInfo.getTotal();
        System.out.println("共有商品:"+total);
        System.out.println(list.size());
    }
}
