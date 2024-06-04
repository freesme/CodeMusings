package freesme.top.hashtable

/**
 * 有效的字母异位词
 * https://leetcode.cn/problems/valid-anagram/description/
 * 若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *  示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 *  示例 2: 输入: s = "rat", t = "car" 输出: false
 *  说明: 你可以假设字符串只包含小写字母
 */

fun isValidWords(s: String, t: String): Boolean {

    if (s.length != t.length) {
        return false;
    }

    val map1 = mutableMapOf<Char, Int>()
    val map2 = mutableMapOf<Char, Int>()
    for (i in s.indices) {
        val char = s[i]
        map1[char] = map1.getOrDefault(char, 0) + 1
        val char2 = t[i]
        map2[char2] = map2.getOrDefault(char2, 0) + 1
    }

    for (map in map1) {
        if (map.value != map2[map.key]) {
            return false
        }
    }
    return true;
}


fun main() {
    println(isValidWords("car", "rac"))
    println(isValidWords("ca2r", "rac"))
}
