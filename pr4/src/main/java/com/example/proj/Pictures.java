package com.example.proj;

public class Pictures {

   public static String buttonName(String name){
        return "<table border=\"3\" bordercolor=\"red\" align=\"center\">\n" +
                "    <tr>\n" +
                "        <th colspan=\"3\">List of medicines</th> \n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <th>Name</th>\n" +
                "        <th>Picture</th>\n" +
                "        <th>Option</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Paracetamol</th>\n" +
                "        <td><img src=\"WebContent\\par.jpg\" border=3 height=100 width=200></img></th>\n" +
                "        <td><button type=\"button\">" + name + "</button>" +
                "<button type=\"button\">Process order</button</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Aspirin</th>\n" +
                "        <td><img src=\"WebContent\\asp.jpg\" border=3 height=100 width=200></img></th>\n" +
                "        <td><button type=\"button\">" + name + "</button>" +
                "<button type=\"button\">Process order</button</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>Ibuprofen</th>\n" +
                "        <td><img src=\"WebContent\\ibu.jpg\" border=3 height=100 width=200></img></th>\n" +
                "        <td><button type=\"button\">" + name + "</button>" +
                "           <button type=\"button\">Process order</button></th>\n" +
                "    </tr>\n" +
                "</table>\n";
    }
}
