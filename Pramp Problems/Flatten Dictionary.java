import java.util.HashMap;

/*
Flatten a Dictionary
A dictionary is a type of data structure that is supported natively in all major interpreted languages such as JavaScript, Python, 
Ruby and PHP, where it’s known as an Object, Dictionary, Hash and Array, respectively. In simple terms, a dictionary is a collection 
of unique keys and their values. The values can typically be of any primitive type (i.e an integer, boolean, double, string etc) or 
other dictionaries (dictionaries can be nested). However, for this exercise assume that values are either an integer, a string or 
another dictionary.

Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it .

If you’re using a compiled language such Java, C++, C#, Swift and Go, you may want to use a Map/Dictionary/Hash Table that maps 
strings (keys) to a generic type (e.g. Object in Java, AnyObject in Swift etc.) to allow nested dictionaries.

If a certain key is empty, it should be excluded from the output (see e in the example below).

Example:

input:  dict = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }
        }

output: {
            "Key1" : "1",
            "Key2.a" : "2",
            "Key2.b" : "3",
            "Key2.c.d" : "3",
            "Key2.c.e" : "1"
        }
Important: when you concatenate keys, make sure to add the dot character between them. For instance concatenating Key2, c and 
d the result key would be Key2.c.d.

Constraints:

[time limit] 5000ms
[input] Dictionary dict
[output] Dictionary
*/

/*
Time of execution of flattenDictionary is 34ms.
*/

/*
Solutions approach:

Recursively calls flattenDictionary for those values that are not an instance of a String.
*/

public class Main {
   static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
       HashMap<String, String> flat = new HashMap<>();
       for (String k: dict.keySet()){
           Object V = dict.get(k);
           if (V instanceof String){
               flat.put(k,(String) V);
           }
           else {
               HashMap<String, Object> tem = new HashMap<>();
               if (k==null || k == "") {
                   for (Object s : ((HashMap) V).keySet()) {
                       tem.put((String) s, ((HashMap) V).get(s));
                  }
                   flat.putAll(flattenDictionary(tem));
               }
               else{
                   for (Object s: ((HashMap) V).keySet()) {
                       if ((String) s == "") tem.put(k, ((HashMap) V).get(s));
                       else {
                           tem.put(k + "." + (String) s, ((HashMap) V).get(s));
                       }
                   }
                   flat.putAll(flattenDictionary(tem));
               }
           }
       }
       return flat;
   }

    public static void main(String[] args) {
        HashMap<String, Object> d = new HashMap<String, Object>();
        d.put("","1");
        HashMap<String, Object> c = new HashMap<String, Object>();
        c.put("d", "3");
        c.put("e", d);
        HashMap<String, Object> key2 = new HashMap<String, Object>();
        key2.put("a", "2");
        key2.put("b", "3");
        key2.put("c", c);
        HashMap<String, Object> dict = new HashMap<String, Object>();
        dict.put("key1", "1");
        dict.put("key2", key2);
            

        System.out.println(dict);
        long a = System.currentTimeMillis();
        System.out.println(flattenDictionary(dict));
        long b = System.currentTimeMillis();
        System.out.println("Total time elapsed: " + (b-a));
    }
}
