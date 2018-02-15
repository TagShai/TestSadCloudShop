package org.mannayakasha.controller.rest;

import org.mannayakasha.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
//@CrossOrigin(origins = {"http://localhost:8100","file://"})
public class ProductController {

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        //List<Product> products = productService.getAll();
        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Alibaba. История мирового восхождения от первого лица");
        product1.setPrice(32.0);
        product1.setDescription("Джек Ма - Рокфеллер XXI века, акции Alibaba в 2014 году побили рекорды, достигнув 25 млрд долларов.");
        product1.setFullDescription("Инсайдерское откровение о том, как один человек построил мировую корпорацию, способную противостоять таким гигантам как Walmart и Amazon.\n" +
                "\n" +
                "Всего за десять лет Джек Ма, бывший перподаватель английского, основал и построил Alibaba Group, в которую сегодня входят: Alibaba.com, Alibaba Pictures, AliExpress.com , Taobao.com, Tmall.com, Alipay и другие.\n" +
                "\n" +
                "Джек Ма - Рокфеллер XXI века, акции Alibaba в 2014 году побили рекорды, достигнув 25 млрд долларов.\n" +
                "\n" +
                "Перед вами история компании и самого Джека, иконы частного предпринимательства и привратника миллионов потребителей от китайского Ханчжоу до тверского Торжка.");
        product1.setImage("32973205.cover_330.jpg");
        product1.setNovelty(true);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Теория каст и ролей");
        product2.setPrice(29.0);
        product2.setDescription("Революционная книга, в которой автор делит общество на касты и описывает роли людей в них.");
        product2.setFullDescription("Революционная книга, в которой автор делит общество на касты и описывает роли людей в них.\n" +
                "\n" +
                "Касты определяют уровень свободы и безопасности каждого человека.\n" +
                "\n" +
                "Рабы, чиновники, жандармы, профессионалы, рантье, топ-менеджеры, олигархи, бизнесмены, властители, жрецы - вы сможете изучить их характеристики и определить свою касту и роль в ней как некую точку отсчета. От нее автор предложит вам путь к высшим кастам, где царит полная свобода и подлинное счастье.\n" +
                "\n" +
                "Эта книга способна изменить жизнь каждого, кто ее прочтет.\n" +
                "\n" +
                "Еще до официальной публикации она имела тысячи приверженцев.");
        product2.setImage("BC4_1513863448.jpg");
        product2.setNovelty(true);

        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Стив Джобс. Биография");
        product3.setPrice(30.0);
        product3.setDescription("Нет никаких причин не следовать велению своего сердца.");
        product3.setFullDescription("\"Мне никогда не попадалось более действенного инструмента, помогающего делать выбор в важные моменты жизни, чем сознание, что я скоро умру. Потому что почти всё – ожидания окружающих, гордость, боязнь попасть в неловкое положение или потерпеть неудачу – все эти вещи просто отступают перед лицом смерти, и остается только то, что действительно важно. Память смертная – лучший из всех известных мне способов избежать западни, в которую вас загоняет мысль о том, что вам есть, что терять. Ты уже голый. Нет никаких причин не следовать велению своего сердца.\" \n" +
                "\n" +
                "Сейчас, когда страны всего мира пытаются выстроить новые экономики эпохи цифровых технологий, Стив Джобс является олицетворением творчества, воображения, изобретательности. ");
        product3.setImage("9781451648539.jpg");
        product3.setNovelty(false);

        products.add(product1);
        products.add(product2);
        products.add(product3);

        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
}
