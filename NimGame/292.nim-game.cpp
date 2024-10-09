/*
 * @lc app=leetcode id=292 lang=cpp
 *
 * [292] Nim Game
 */

// @lc code=start
class Solution {
public:
    bool canWinNim(int n) {
        return nimGameHelper(n,true);
    }
    bool nimGameHelper(int n ,bool isSelf){
        if(n<=3){
            return isSelf;
        }

        bool iswin = false;
        for(int i=1;i<=3;i++){
            iswin = (iswin || nimGameHelper(n-i,!isSelf));
        }
        return iswin;
    }
};
// @lc code=end

