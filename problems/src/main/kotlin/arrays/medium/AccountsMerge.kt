package arrays.medium

/**
 * Problem: 721. Accounts Merge
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * 
 * Solution:
 * The main idea that each of email we can represent as graph node and we can connect all emails that belong to the same account. 
 * After that we can use DFS to traverse the graph and collect all emails that belong to the same account.
 * The function uses a set to keep track of visited emails and a map to store the adjacent emails.
 * It iterates through the accounts and connects the emails that belong to the same account.
 * It then iterates through the accounts and uses DFS to traverse the graph and collect all emails that belong to the same account.
 * The function returns the result list containing the merged accounts.
 */
object AccountsMerge {

    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val seen = mutableSetOf<String>()
        val adjacent = mutableMapOf<String, MutableList<String>>()
        
        for(account in accounts) {
            val firstEmail = account[1]

            for(i in 2..<account.size) {
                if(!adjacent.containsKey(firstEmail)) {
                    adjacent[firstEmail] = mutableListOf<String>()
                }

                adjacent[firstEmail]!!.add(account[i])

                if(!adjacent.containsKey(account[i])) {
                    adjacent[account[i]] = mutableListOf<String>()
                }

                adjacent[account[i]]!!.add(firstEmail)
            }
        }

        val result = mutableListOf<MutableList<String>>()

        for(account in accounts) {
            val accountName = account[0]
            val firstEmail = account[1]

            if(!seen.contains(firstEmail)) {
                val mergedAccount = mutableListOf<String>()

                mergedAccount.add(accountName)
                dfs(mergedAccount, firstEmail, seen, adjacent)
                mergedAccount.subList(1, mergedAccount.size).sort()
                result.add(mergedAccount);
            }
        }

        return result
    }

    private fun dfs(mergedAccount: MutableList<String>, email: String, seen: MutableSet<String>, adjacent: MutableMap<String, MutableList<String>>) {
        seen.add(email)

        mergedAccount.add(email)

        if(!adjacent.contains(email)) {
            return
        }

        for(neighbor in adjacent[email]!!) {
            if(!seen.contains(neighbor)) {
                dfs(mergedAccount, neighbor, seen, adjacent)
            }
        }
    }
}
