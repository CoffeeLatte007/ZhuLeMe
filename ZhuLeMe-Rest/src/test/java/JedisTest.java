import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/**
 * Created by lz on 2016/6/16.
 */
public class JedisTest {
    @Test
    public void testJedisSingle(){

        //创建一个Jedis对象
        Jedis jedis=new Jedis("115.28.110.26",6379);
        //调用jedis对象的方法
        jedis.set("ke","jedis test");
        String string=jedis.get("ke");
        System.out.println(string);
        jedis.close();
    }
}
