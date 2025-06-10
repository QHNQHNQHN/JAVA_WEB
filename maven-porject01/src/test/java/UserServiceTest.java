import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
测试类
 */
@DisplayName("用户信息的测试类")
public class UserServiceTest {
    @Test
    public void testGetAge(){
        UserService userService = new UserService();
        Integer age = userService.getAge("321023200106224034");
        System.out.println(age);
    }
    @Test
    public void testGetGender(){
        UserService userService = new UserService();
        String gender = userService.getGender("321023200106224034");
        System.out.println(gender);
    }

    //断言
    @Test
    public void testGenderWithAssert(){
        UserService userService = new UserService();
        String gender = userService.getGender("321023200106224034");
        //断言
        //Assertions.assertEquals("男",gender);
        Assertions.assertEquals("男",gender,"性别获取逻辑有问题");
    }
    @Test
    public void testGenderWithAssert2() {
        UserService userService = new UserService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(null);
        });
    }

    //参数化测试
    @DisplayName("测试用户性别")
    @ParameterizedTest
    @ValueSource(strings = {"321023200106224034","321023200106224014","321023200106224054"})
    public void testGetGender2(String idCard){
        UserService userService = new UserService();
        String gender = userService.getGender(idCard);
        //断言
        //Assertions.assertEquals("男",gender);
        Assertions.assertEquals("男",gender,"性别获取逻辑有问题");
    }
}
