package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0721 {

    private static class DSU {
        int[] parent;
        DSU(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int z) {
            if (parent[z] != z) {
                parent[z] = find(parent[z]);
                return parent[z];
            } else {
                return z;
            }
        }
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;
            }
        }
    }
    private static class AccountBean {
        String name;
        List<String> emails;
        AccountBean() {
            emails = new ArrayList<>();
        }
        void addEmail(String email){
            if (!emails.contains(email)) {
                emails.add(email);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return new ArrayList<>();
        }
        Set<String> emailSet = new HashSet<>();
        int n = 0;
        for (List<String> account : accounts) {
            n += account.size() - 1;
            for (int i = 1; i < account.size(); i++) {
                emailSet.add(account.get(i));
            }
        }
        Map<String, Integer> emailId = new HashMap<>(emailSet.size());
        Map<Integer, String> idEmail = new HashMap<>(emailSet.size());
        int id = 0;
        for (String email : emailSet) {
            emailId.put(email, id);
            idEmail.put(id, email);
            id ++;
        }
        DSU dsu = new DSU(n + 1);
        for (List<String> account : accounts) {
            if (account.size() > 2) {
                for (int i = 2; i < account.size(); i++) {
                    dsu.union(emailId.get(account.get(i)),
                            emailId.get(account.get(i - 1)));
                }
            }
        }
        Map<String, AccountBean> map = new HashMap<>(emailSet.size());
        for (List<String> account : accounts) {
            String fEmail = account.get(1);
            AccountBean bean = map.computeIfAbsent(
                    idEmail.get(dsu.find(emailId.get(fEmail))),
                    k -> new AccountBean());
            bean.name = account.get(0);
            for (String email : account.subList(1, account.size())) {
                bean.addEmail(email);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (AccountBean bean : map.values()) {
            List<String> list = new ArrayList<>();
            list.add(bean.name);
            List<String> emails = bean.emails;
            Collections.sort(emails);
            list.addAll(emails);
            res.add(list);
        }
        return res;
    }

    private void test1() {
        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>();
        account1.add("John");
        account1.add("johnsmith@mail.com");
        account1.add("john00@mail.com");
        accounts.add(account1);
        List<String> account2 = new ArrayList<>();
        account2.add("John");
        account2.add("johnnybravo@mail.com");
        accounts.add(account2);
        List<String> account3 = new ArrayList<>();
        account3.add("John");
        account3.add("johnsmith@mail.com");
        account3.add("john_newyork@mail.com");
        accounts.add(account3);
        List<String> account4 = new ArrayList<>();
        account4.add("Mary");
        account4.add("mary@mail.com");
        accounts.add(account4);
        System.out.println(accountsMerge(accounts));
    }
    private void test2() {
        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>();
        account1.add("David");
        account1.add("David0@m.co");
        account1.add("David4@m.co");
        account1.add("David3@m.co");
        accounts.add(account1);
        List<String> account2 = new ArrayList<>();
        account2.add("David");
        account2.add("David5@m.co");
        account2.add("David5@m.co");
        account2.add("David0@m.co");
        accounts.add(account2);
        List<String> account3 = new ArrayList<>();
        account3.add("David");
        account3.add("David1@m.co");
        account3.add("David4@m.co");
        account3.add("David0@m.co");
        accounts.add(account3);
        List<String> account4 = new ArrayList<>();
        account4.add("David");
        account4.add("David0@m.co");
        account4.add("David1@m.co");
        account4.add("David3@m.co");
        accounts.add(account4);
        List<String> account5 = new ArrayList<>();
        account5.add("David");
        account5.add("David4@m.co");
        account5.add("David1@m.co");
        account5.add("David3@m.co");
        accounts.add(account5);
        System.out.println(accountsMerge(accounts));
    }

    public static void main(String[] args) {
        LeetCode0721 main = new LeetCode0721();
        main.test2();
    }
}
