package me.nilme.exercise.mock;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author weizhuang
 * Created on 2019-09-10.
 */
public class Main {


    public static void main(String[] args) {
        try
        {
            Document document = Jsoup.parse( new File( "/Users/weizhuang/workspace/github/exercise-book/exercise-moke/src/main/resources/test2.html" ) , "utf-8" );

            JXDocument jxd = JXDocument.create(document);

            //出生年月
            List<JXNode> britdh = jxd.selN("//body/table[2]/tbody/tr[5]/td/table/tbody/tr[2]/td[2]/div/font/font");
            System.out.println(britdh.get(0).asElement().text());

            List<JXNode> xueli = jxd.selN("//body/table[2]/tbody/tr[5]/td/table/tbody/tr[2]/td[7]/div/font/span");
            System.out.println(xueli.get(0).asElement().text());

            List<JXNode> xxxx = jxd.selN("//body/table[2]/tbody/tr[15]/td/div/table/tbody/tr[2]/td[1]/div/font");
            System.out.println(xxxx.get(0).asElement().text());

            //贷记卡
            List<JXNode> daijika = jxd.selN("//tr[@height='35']");
            for (JXNode jxNode : daijika) {

                List<JXNode> sel = jxNode.sel("./td/div/b/font/span");

                if (sel.size()>0){
                    System.out.println(sel.get(0).asElement().text());
                }
            }

//            //贷记卡带有截至表格
//            //cellspacing="0"
//            List<JXNode> daijikabiaoge = jxd.selN("//table[@class='tableStyle' and not(@border)]");
////            List<JXNode> daijikabiaoge = jxd.selN("//table[@cellspacing='0']");
//            for (JXNode jxNode : daijikabiaoge) {
//                System.out.println(jxNode.toString());
//            }
//

            //准贷记卡
            List<JXNode> zhundaijika = jxd.selN("//tr[@style='line-height:25px' and not(@height)]/td/div");
            for (JXNode jxNode : zhundaijika) {
                System.out.println(jxNode.toString());
            }




        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
