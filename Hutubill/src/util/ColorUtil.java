// 颜色渐变工具
package util;

import java.awt.Color;

public class ColorUtil {
    /**
     * 定义四种常用颜色
     * */
    public static Color blueColor = Color.decode("#3399FF");
    public static Color grayColor = Color.decode("#999999");
    public static Color backgroundColor = Color.decode("#eeeeee");
    public static Color warningColor = Color.decode("#FF3333");


    /**
     * 将百分比 per 转换为 0 到 100 之间的颜色
     * 颜色从绿色（51, 255, 51）逐渐变为黄色（255, 51, 51）。
     * @param per 百分比
     * @return
     * */
    public static Color getByPercentage(int per) {
        // 最多只能是100%
        if (per > 100)
            per = 100;
        float rate = per / 100f;

        // 定义一种初始颜色
        int r = 51;
        int g = 255;
        int b = 51;

        r = (int) (204 * rate + 51);
        g = 255 - r + 51;

        Color color = new Color(r, g, b);
        return color;
    }
}