package freesme.top.hashtable

import freesme.top.utils.runTime
import java.util.*

/**
 * 有效的字母异位词
 * https://leetcode.cn/problems/valid-anagram/description/
 * 若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *  示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 *  示例 2: 输入: s = "rat", t = "car" 输出: false
 *  说明: 你可以假设字符串只包含小写字母
 */

/**
 * 使用两个map，较差的解法
 */
fun isValidWords(s: String, t: String): Boolean {

    if (notEqualLength(s, t)) return false

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

/**
 * 只使用一个map
 */
fun isValidWords2(s: String, t: String): Boolean {
    if (notEqualLength(s, t)) return false

    val map = mutableMapOf<Char, Int>();
    for (i in s.indices) {
        val char = s[i]
        map[char] = map.getOrDefault(char, 0) + 1
        val char2 = t[i]
        map[char2] = map.getOrDefault(char2, 0) - 1
    }

    for (entry in map) {
        if (entry.value != 0) {
            return false
        }
    }
    return true;
}

fun isValidWordsBetterThan2(s: String, t: String): Boolean {
    if (notEqualLength(s, t)) return false
    val record = IntArray(26)
    for (i in s.indices) {
        record[s[i] - 'a']++
        record[t[i] - 'a']--
    }
    for (i in record) {
        if (i != 0) {
            return false
        }
    }
    return true;
}

/**
 * 使用排序
 */
fun isValidWords3(s: String, t: String): Boolean {

    if (notEqualLength(s, t)) return false
    val sArr = s.toCharArray()
    Arrays.sort(sArr)
    val tArr = t.toCharArray()
    Arrays.sort(tArr)
    return String(sArr) == String(tArr)

}

private fun notEqualLength(s: String, t: String): Boolean {
    return s.length != t.length
}

fun main() {
    runTime("isValidWords2") { isValidWords2("car", "rac") }
    // fastest
    runTime("isValidWordsBetterThan2") { isValidWordsBetterThan2("car", "rac") }
    runTime("isValidWords3") { isValidWords3("car", "rac") }
}
