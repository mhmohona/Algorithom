#include <bits/stdc++.h>

using namespace std;

int main(){
	int n;
	int ip[1000001];
	scanf("%d",&n);
	
	for(int i=1;i<=n;i++) ip[i]=0;
	
	for(int i=1;i<n;i++){
		for(int j=i;j<=n;j=j+i) ip[j]++;

	}
	for(int i=0;i<n;i++)
    cout << ip[i] << endl;
    return 0;
}
