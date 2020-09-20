package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode11707 {

    private static class DSU {
        int[] parent;
        DSU(int[] parent) {
            this.parent = parent;
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

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Set<String> synonymSet = new HashSet<>();
        // 解析 names
        Map<String, Integer> nameMap = new HashMap<>(names.length);
        for (String name : names) {
            name = name.replace(")", "");
            String[] arr = name.split("\\(");
            nameMap.put(arr[0], Integer.parseInt(arr[1]));
            synonymSet.add(arr[0]);
        }
        // 解析 synonyms
        String[][] synonymsArr = new String[synonyms.length][2];
        for (int i = 0; i < synonyms.length; i++) {
            String synonym = synonyms[i];
            synonym = synonym.replace("(", "")
                    .replace(")", "");
            String[] arr = synonym.split(",");
            synonymsArr[i] = arr;
            synonymSet.add(arr[0]);
            synonymSet.add(arr[1]);
        }
        Map<String, Integer> synonymId = new HashMap<>(synonymSet.size());
        Map<Integer, String> idSynonym = new HashMap<>(synonymSet.size());
        int id = 0;
        for (String synonym : synonymSet) {
            synonymId.put(synonym, id);
            idSynonym.put(id, synonym);
            id ++;
        }
        int[] parent = new int[synonymSet.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        DSU dsu = new DSU(parent);
        for (String[] arr : synonymsArr) {
            String left = idSynonym.get(dsu.find(synonymId.get(arr[0])));
            String right = idSynonym.get(dsu.find(synonymId.get(arr[1])));
            if (left.compareTo(right) > 0) {
                dsu.union(synonymId.get(left), synonymId.get(right));
            } else {
                dsu.union(synonymId.get(right), synonymId.get(left));
            }
        }
        Map<String, Integer> resMap = new HashMap<>(synonymSet.size());
        for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
            String key = idSynonym.get(dsu.find(synonymId.get(entry.getKey())));
            resMap.put(key, resMap.getOrDefault(key, 0) + entry.getValue());
        }
        String[] res = new String[resMap.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : resMap.entrySet()) {
            res[i ++] = entry.getKey() + "(" + entry.getValue() + ")";
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode11707 main = new LeetCode11707();
        System.out.println(Arrays.toString(
                main.trulyMostPopular(
                        new String[] {"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"},
                        new String[] {"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"}
                )
        ));
        System.out.println(Arrays.toString(
                main.trulyMostPopular(
                        new String[]{"Fcclu(70)", "Ommjh(63)", "Dnsay(60)", "Qbmk(45)", "Unsb(26)", "Gauuk(75)", "Wzyyim(34)", "Bnea(55)", "Kri(71)", "Qnaakk(76)", "Gnplfi(68)", "Hfp(97)", "Qoi(70)", "Ijveol(46)", "Iidh(64)", "Qiy(26)", "Mcnef(59)", "Hvueqc(91)", "Obcbxb(54)", "Dhe(79)", "Jfq(26)", "Uwjsu(41)", "Wfmspz(39)", "Ebov(96)", "Ofl(72)", "Uvkdpn(71)", "Avcp(41)", "Msyr(9)", "Pgfpma(95)", "Vbp(89)", "Koaak(53)", "Qyqifg(85)", "Dwayf(97)", "Oltadg(95)", "Mwwvj(70)", "Uxf(74)", "Qvjp(6)", "Grqrg(81)", "Naf(3)", "Xjjol(62)", "Ibink(32)", "Qxabri(41)", "Ucqh(51)", "Mtz(72)", "Aeax(82)", "Kxutz(5)", "Qweye(15)", "Ard(82)", "Chycnm(4)", "Hcvcgc(97)", "Knpuq(61)", "Yeekgc(11)", "Ntfr(70)", "Lucf(62)", "Uhsg(23)", "Csh(39)", "Txixz(87)", "Kgabb(80)", "Weusps(79)", "Nuq(61)", "Drzsnw(87)", "Xxmsn(98)", "Onnev(77)", "Owh(64)", "Fpaf(46)", "Hvia(6)", "Kufa(95)", "Chhmx(66)", "Avmzs(39)", "Okwuq(96)", "Hrschk(30)", "Ffwni(67)", "Wpagta(25)", "Npilye(14)", "Axwtno(57)", "Qxkjt(31)", "Dwifi(51)", "Kasgmw(95)", "Vgxj(11)", "Nsgbth(26)", "Nzaz(51)", "Owk(87)", "Yjc(94)", "Hljt(21)", "Jvqg(47)", "Alrksy(69)", "Tlv(95)", "Acohsf(86)", "Qejo(60)", "Gbclj(20)", "Nekuam(17)", "Meutux(64)", "Tuvzkd(85)", "Fvkhz(98)", "Rngl(12)", "Gbkq(77)", "Uzgx(65)", "Ghc(15)", "Qsc(48)", "Siv(47)"},
                        new String[]{"(Gnplfi,Qxabri)","(Uzgx,Siv)","(Bnea,Lucf)","(Qnaakk,Msyr)","(Grqrg,Gbclj)","(Uhsg,Qejo)","(Csh,Wpagta)","(Xjjol,Lucf)","(Qoi,Obcbxb)","(Npilye,Vgxj)","(Aeax,Ghc)","(Txixz,Ffwni)","(Qweye,Qsc)","(Kri,Tuvzkd)","(Ommjh,Vbp)","(Pgfpma,Xxmsn)","(Uhsg,Csh)","(Qvjp,Kxutz)","(Qxkjt,Tlv)","(Wfmspz,Owk)","(Dwayf,Chycnm)","(Iidh,Qvjp)","(Dnsay,Rngl)","(Qweye,Tlv)","(Wzyyim,Kxutz)","(Hvueqc,Qejo)","(Tlv,Ghc)","(Hvia,Fvkhz)","(Msyr,Owk)","(Hrschk,Hljt)","(Owh,Gbclj)","(Dwifi,Uzgx)","(Iidh,Fpaf)","(Iidh,Meutux)","(Txixz,Ghc)","(Gbclj,Qsc)","(Kgabb,Tuvzkd)","(Uwjsu,Grqrg)","(Vbp,Dwayf)","(Xxmsn,Chhmx)","(Uxf,Uzgx)"}
                )
        ));
        main.test();
    }

    private void test() {
        // 查区别
        String[] names1 = new String[]
                {"Nzaz(51)","Gbkq(77)","Uxf(237)","Gauuk(75)","Chycnm(253)","Axwtno(57)","Chhmx(259)","Mtz(72)","Hfp(97)","Ijveol(46)","Koaak(53)","Jfq(26)","Mwwvj(70)","Bnea(179)","Ntfr(70)","Avcp(41)","Obcbxb(124)","Jvqg(47)","Npilye(25)","Fcclu(70)","Qbmk(45)","Gnplfi(109)","Fpaf(219)","Yeekgc(11)","Ard(82)","Kgabb(236)","Weusps(79)","Nekuam(17)","Qyqifg(85)","Alrksy(69)","Avmzs(39)","Acohsf(86)","Ibink(32)","Qiy(26)","Dhe(79)","Hvueqc(238)","Ebov(96)","Hljt(51)","Onnev(77)","Gbclj(646)","Yjc(94)","Ofl(72)","Oltadg(95)","Okwuq(96)","Fvkhz(104)","Unsb(26)","Hcvcgc(97)","Uvkdpn(71)","Kufa(95)","Nsgbth(26)","Nuq(61)","Ucqh(51)","Dnsay(72)","Mcnef(59)","Naf(3)","Drzsnw(87)","Msyr(211)","Kasgmw(95)","Knpuq(61)"};
        String[] names2 = new String[] {"Fcclu(70)","Dnsay(72)","Qbmk(45)","Unsb(26)","Gauuk(75)","Gnplfi(109)","Hfp(97)","Obcbxb(124)","Ijveol(46)","Fpaf(219)","Qiy(26)","Mcnef(59)","Dhe(79)","Jfq(26)","Ebov(96)","Ofl(72)","Uvkdpn(71)","Avcp(41)","Chycnm(253)","Koaak(53)","Qyqifg(85)","Oltadg(95)","Mwwvj(70)","Naf(3)","Ibink(32)","Ucqh(51)","Mtz(72)","Ard(82)","Hcvcgc(97)","Knpuq(61)","Yeekgc(11)","Ntfr(70)","Bnea(179)","Weusps(79)","Nuq(61)","Drzsnw(87)","Chhmx(259)","Onnev(77)","Kufa(95)","Avmzs(39)","Okwuq(96)","Hljt(51)","Npilye(25)","Axwtno(57)","Kasgmw(95)","Nsgbth(26)","Nzaz(51)","Msyr(211)","Yjc(94)","Jvqg(47)","Alrksy(69)","Aeax(646)","Acohsf(86)","Csh(238)","Nekuam(17)","Kgabb(236)","Fvkhz(104)","Gbkq(77)","Dwifi(237)"};
        Map<String, Integer> nameMap1 = new HashMap<>(names1.length);
        for (String name : names1) {
            name = name.replace(")", "");
            String[] arr = name.split("\\(");
            nameMap1.put(arr[0], Integer.parseInt(arr[1]));
        }
        Map<String, Integer> nameMap2 = new HashMap<>(names2.length);
        for (String name : names2) {
            name = name.replace(")", "");
            String[] arr = name.split("\\(");
            nameMap2.put(arr[0], Integer.parseInt(arr[1]));
        }
        for (Map.Entry<String, Integer> entry : nameMap1.entrySet()) {
            if (!nameMap2.containsKey(entry.getKey())) {
                // 程序有答案没有
                System.out.println(entry.getKey());
            }
        }
        System.out.println("===============");
        for (Map.Entry<String, Integer> entry : nameMap2.entrySet()) {
            if (!nameMap1.containsKey(entry.getKey())) {
                // 答案有程序没有
                System.out.println(entry.getKey());
            }
        }
    }
}