import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceAiTest {

    private UserService userService;
    @BeforeEach // 在每个测试方法执行前执行
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void getGender_ValidMaleIdCard_ReturnsMale() {
        String gender = userService.getGender("100000200010011011");
        assertEquals("男", gender, "性别获取错误，应为男性");
    }

    @Test
    public void getGender_ValidFemaleIdCard_ReturnsFemale() {
        String gender = userService.getGender("100000200010011022");
        assertEquals("女", gender, "性别获取错误，应为女性");
    }

    @Test
    public void getGender_NullIdCard_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(null);
        }, "无效的身份证号码");
    }

    @Test
    public void getGender_InvalidLengthIdCard_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("10000020001001101");
        }, "无效的身份证号码");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100000200010011011", "100000200010011031", "100000200010011051"})
    public void getGender_MultipleMaleIdCards_ReturnsMale(String idCard) {
        String gender = userService.getGender(idCard);
        assertEquals("男", gender, "性别获取错误，应为男性");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100000200010011022", "100000200010011042", "100000200010011062"})
    public void getGender_MultipleFemaleIdCards_ReturnsFemale(String idCard) {
        String gender = userService.getGender(idCard);
        assertEquals("女", gender, "性别获取错误，应为女性");
    }

    //测试年龄-正常
    @Test
    @DisplayName("获取年龄-正常身份证")
    public void testGetAge() {
        Integer age = userService.getAge("100000200010011011");
        Assertions.assertEquals(24,age);
    }
    //测试年龄-null值
    @Test
    @DisplayName("获取年龄-null值")
    public void testGetAge2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge(null);
        });
    }
    //测试年龄-长度过长
    @Test
    @DisplayName("获取年龄-长度超长")
    public void testGetAge3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge("10000020001001101111");
        });
    }
    //测试年龄-长度不足
    @Test
    @DisplayName("获取年龄-长度超长")
    public void testGetAge4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge("100000200010011");
        });
    }
}
