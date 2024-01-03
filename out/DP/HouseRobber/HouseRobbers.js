function rob(nums) {
    var n = nums.length;
    var dp = [];
    if (n == 0 || n == 1)
        return nums[n];
    dp[0] = nums[0];
    dp[1] = nums[1];
    for (var i = 2; i < n; i++) {
        var max = Number.MIN_VALUE;
        for (var j = 0; j < i - 1; j++) {
            max = Math.max(max, dp[j]);
        }
        dp[i] = max + nums[i];
    }
    return Math.max(dp[n - 2], dp[n - 1]);
}
;
var nums = [2, 7, 9, 3, 1];
console.log(rob(nums));
//# sourceMappingURL=HouseRobbers.js.map