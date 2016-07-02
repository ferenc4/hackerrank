Brief Explanation:
you can carefully observed that the problem essentially asked you to check whether this equality holds  for some integral value of  or not .If yes then the number of steps required to reach block will be  else we cannot reach  block.
Approach:
Method 1:
A careful observation reveals this result that for every integral value of  this function  will generate a valid state where we can always reach in exact  steps. Another observation shows you that the mentioned function is strictly increasing function and we can do binary search to find answer.

Method2:
However, This problem can be solved more optimally in terms of Big-oh notation. 
As I mentioned in the explantion that solution to the given state always exists if the given equality holds.So, we can find the roots of this Quadratic equation and check whether the given equation holds for the roots if yes then we are done else we cannot reach to the  block. 
Author's solution make use of this approach.
 Tested by tmt514

Problem Tester's code :
```C++
#include <cstdio>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;

#define FOR(it, c) for(__typeof((c).begin()) it = (c).begin(); it != (c).end(); it++)
#define SZ(c) ((int)(c).size())
typedef long long LL;

void solve() {
  LL n, v;
  scanf("%lld", &n);
  v = (LL)sqrt(2.*n);
  v = max(0LL, v-1);
  while(v*(v+1) < 2*n) ++v;
  if (v*(v+1) == 2*n) printf("Go On Bob %lld\n", v);
  else printf("Better Luck Next Time\n");
}

int main(void) {
  int T;
  scanf("%d", &T);
  while(T--) solve();
  return 0;
}
```