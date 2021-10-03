public class Main {
    public static void main(String[] args) {
        Trie tr=new Trie();
        tr.insert("APIIS");
        tr.insert("AP");
        tr.searchTree("APIS");
        tr.delete("APIIS");       //bc delete method calls search
        tr.searchTree("APIS");
    }
}
