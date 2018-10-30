package com.talkingdata.appanalytics.plugin.views;

import com.intellij.ui.JBColor;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JLabel;
/**
 *
 * 超链接文本标签类
 * @author liuxing
 *
 */
public class LinkLabel extends JLabel {
    private static final long serialVersionUID = 1L;
    /** 超链接显示的文字 */
    private String text;
    /** 保存连接 */
    private URL link = null;
    /** 保存标签的默认颜色 */
    private Color preColor = null;

    /** * 构造一个超链接 * @param vText 显示的文字 * @param vLink 连接地址 */
    public LinkLabel(String vText, String vLink) {
        super("<html>" + vText + "</html>");
        this.text = vText;
        setCursor(Cursor
                .getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setForeground(JBColor.blue);
        setLink(vLink);
    }

    public void setLink(String link){
        try {
            if (!link.startsWith("http://")) {
                link = "http://" + link;
            }
            this.link = new URL(link);
        } catch (MalformedURLException err) {
            err.printStackTrace();
        }
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                LinkLabel.this.setCursor(Cursor
                        .getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                LinkLabel.this.setText("<html>" + LinkLabel.this.text + "</html>");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                LinkLabel.this.setCursor(Cursor
                        .getPredefinedCursor(Cursor.HAND_CURSOR));
                LinkLabel.this.setText("<html><u>" + LinkLabel.this.text + "</u></html>");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(LinkLabel.this.link.toURI());
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        });
    }

}

