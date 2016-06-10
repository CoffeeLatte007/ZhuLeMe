package java1;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by lz on 2016/6/3.
 */
public class test1 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
         TbItemMapper itemMapper= (TbItemMapper) context.getBean("tbItemMapper");
        System.out.println(1);
        TbItemExample example=new TbItemExample();
        System.out.println(1);
        TbItemExample.Criteria criteria=example.createCriteria();
        System.out.println(1);
        criteria.andIdEqualTo((long) 536563);
        System.out.println(1);
        List<TbItem> list=itemMapper.selectByExample(example);
        System.out.println(1);
    }
}
