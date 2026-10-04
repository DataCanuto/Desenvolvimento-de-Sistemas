
import java.util.List;
import java.util.stream.Collectors;




public class App {
    public static void main(String[] args) throws Exception {

        /*Random generate
        var value1 = Stream.generate(() -> new Random().nextInt(-10000,1))
        .limit(5).toArray(Integer[]::new);

        for(var v : value1){
            System.out.println(v);
        }*/


        /*Filter    

        var valueString = Stream.of("Maria","João","Marcio","Luana","Leandro","Marcia").filter(name -> name.startsWith("a"));

        valueString.forEach(v -> System.out.println(v));*/

        /*

        //Reudce 
        var value = Stream.of(1,2,3,4,5,6,7,8,9).reduce(0,Integer::sum);
        System.out.println(value);

        //Replace
        var valueStrings = Stream.of("João","17","Estudante").reduce("",(a,b) -> a + "," + b).replaceFirst(",","");
        System.out.println(valueStrings);

        //Distinct
        var valueNames = Stream.of("João","João","Juca","Leo","Maria","Maria").distinct().toList();

        System.out.println(valueNames);

        var valueMap = Stream.of(1,2,3,4,5,6,7,8,7,8,7,8).map(n -> n % 2 == 0).toList();

        System.out.println(valueMap);
        */

        List<Integer> values1 = List.of(3,6,9,12);
        List<Integer> values2 = List.of(1,2,3,4,5,6,7,8,9,10,11,12);

        var valueStream = values2.stream()
            .filter(values1::contains)
            .peek(n -> System.out.printf("Filter %s \n",n))
            .map(n -> values1.stream().reduce(n,(n1,n2) -> n1 - n2))
            .collect(Collectors.toSet());

        System.out.println(valueStream);

        
        


       
        
    }
}
