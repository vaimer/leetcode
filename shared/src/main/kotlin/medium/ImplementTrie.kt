package medium

/**
 * Problem: 208. Implement Trie (Prefix Tree)
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 * 
 * Solution:
 * The Trie class contains a nested Node data class, which represents each node in the trie.
 * Each Node has a value of type Char, a wordEnd flag to indicate if the node marks the end of a word, and a childs map to store child nodes. 
 * The childs map uses integers as keys, which are derived from the character values.
 * 
 * The insert method adds a word to the trie. It starts at the root node and iterates through each character of the word. For each character, it checks if a corresponding child node exists. 
 * If it does, it moves to that child node. If not, it creates a new node and adds it to the childs map. After processing all characters, it marks the last node as the end of a word.
 * 
 * The search method checks if a word exists in the trie. It starts at the root node and iterates through each character of the word. For each character, it checks if a corresponding child node exists. 
 * If any character does not have a corresponding child node, the method returns false. If all characters are found, it returns the wordEnd flag of the last node to determine if the word exists.
 * 
 * The startsWith method checks if any word in the trie starts with a given prefix. It follows a similar process to the search method but only checks for the existence of the prefix, not the wordEnd flag.
 */
object ImplementTrie {
    class Trie() {

        data class Node(
            val value: Char,
            var wordEnd: Boolean = false,
            val childs: MutableMap<Int, Node> = mutableMapOf()
        )

        private val root  = Node(
            value = '$'
        )

        fun insert(word: String) {
            var current = root

            for(char in word) {
                val child = current.childs[char - 'a']

                if(child != null) {
                    current = child
                } else {
                    val newNode = Node(char)
                    current.childs[char - 'a'] = newNode
                    current = newNode
                }
            }

            current.wordEnd = true
        }

        fun search(word: String): Boolean {
            var current = root

            for(char in word) {
                val child = current.childs[char - 'a']

                if(child == null) {
                    return false
                }

                current = child
            }

            return current.wordEnd
        }

        fun startsWith(prefix: String): Boolean {
            var current = root

            for(char in prefix) {
                val child = current.childs[char - 'a'] ?: return false

                current = child
            }

            return true
        }
    }
}
