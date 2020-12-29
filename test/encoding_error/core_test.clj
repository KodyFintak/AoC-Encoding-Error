(ns encoding-error.core-test
  (:require [clojure.test :refer :all]
            [encoding-error.core :refer :all]))

(def one-through-25 (range 1 26))

(deftest valid-with-preamble-test
  (testing "number given is invalid"
    (is (= false (valid-with-preamble? one-through-25 1000))))
  (testing "number given is valid"
    (is (= true (valid-with-preamble? one-through-25 26)))))

(deftest find-invalid-xmas-number-test
  (testing "26th number is invalid"
    (is (= 1000 (find-invalid-xmas-number (concat one-through-25 `(1000))))))
  (testing "Can handle no preamble"
    (is (= nil (find-invalid-xmas-number '(1 2)))))
  (testing "27th number is invalid"
    (is (= 537 (find-invalid-xmas-number (concat one-through-25 `(26 537))))))
  (testing "Finds first invalid number"
    (is (= 1000 (find-invalid-xmas-number (concat one-through-25 `(1000 10001))))))
  (testing "Passes Advent of Code Input"
    (is (= 22477624 (find-invalid-xmas-number '(14 39 44 32 47 15 16 42 35 41 4 23 24 11 12 21 2 26 43 9 38 3 1 8 20 33 5 6 7 49 18 10 16 19 13 15 31 41 65 44 11 34 4 12 14 23 9 56 17 21 20 22 24 25 26 27 18 28 16 19 13 32 15 29 30 33 39 31 34 55 51 53 38 35 36 37 64 44 40 41 42 45 43 28 46 48 83 81 71 66 59 102 62 118 72 121 63 75 65 68 69 70 73 74 76 99 89 103 87 94 107 142 122 191 124 125 127 128 131 137 132 133 167 134 141 139 146 176 304 213 181 194 309 201 247 232 246 250 249 251 256 255 354 279 266 300 267 308 273 280 285 370 357 375 382 443 395 506 433 619 650 495 499 874 651 563 930 533 539 546 540 581 553 648 565 718 770 732 757 828 838 928 932 966 994 1407 1028 1032 1335 1073 1072 1079 1251 1085 1086 1093 1575 1576 2008 1283 1488 1570 1489 2567 2045 1770 1860 1898 2217 2022 2151 2060 2655 2145 2158 2157 4374 2368 4218 2179 2376 2771 2772 2853 3058 2977 3059 3259 3958 3630 3668 4049 4794 4082 4167 4205 4217 4302 4303 4336 5215 6581 4547 5438 5032 5147 5543 5625 6318 6035 6036 6689 6889 9293 7298 7970 8131 9249 8249 8553 11192 8519 12514 11063 13796 9579 9694 9985 14792 19616 13756 11168 11660 12071 12724 12925 13578 14187 15268 16684 16101 16380 17802 28344 17072 34408 18098 19273 28370 19564 19679 21354 27112 22828 25649 23239 24585 26911 31676 26302 26503 27765 29455 42392 32481 33173 34182 35900 35170 36345 53268 62071 49724 39243 40918 44264 44182 46067 51004 47824 51088 50887 52805 58783 54067 98872 68343 61936 114876 89613 143136 90642 72245 98249 119347 149425 90249 218219 266043 271024 88446 100134 93891 98711 100629 109871 324826 106872 112850 231582 190242 130279 134181 162887 160691 162494 170494 212984 332331 422580 495218 178695 182337 279324 222627 188580 261320 194520 199340 216743 288566 219722 392174 374170 401322 264460 290970 596791 323185 665782 493679 373215 455840 361032 393860 449900 370917 376857 405323 483086 383100 572555 411263 621044 510692 484182 696400 587645 647560 555430 669783 661887 731949 684217 767075 734247 861163 747774 737889 754017 960753 759957 782180 889505 794363 867282 895445 1081046 994874 1039612 1071827 1143075 1239647 1385449 1217317 1331670 1346104 1438234 1422106 1472136 2084599 1485663 1828820 1520069 2041799 1542137 1554320 2696102 2129152 2010357 1762727 1890319 2759716 2034486 2182687 2214902 2528524 2781784 2548987 2639423 2677774 2860340 3583936 2894242 3410388 3702756 3005732 5618422 3062206 3317047 4091124 4139509 3653046 3797213 4418843 4105221 4073006 6261710 4217173 7355802 4743426 6380530 5188410 5226761 5754582 7866184 6708488 5899974 6416120 6067938 7135212 6322779 6379253 6715252 7758267 8244730 8071889 7450259 9859803 11159546 10140944 8290179 10117147 9405583 9931836 9970187 10415171 10942992 11549540 20258091 13971863 11967912 12738899 14706299 17899211 17865430 12702032 13094505 14165511 22561835 17310062 19265386 17420446 17695762 18222015 31392309 19839719 19337419 34043718 19902023 20385358 40097810 25440931 28871810 32571729 24669944 36647481 35300734 22477624 25796537 27260016 26867543 30404567 34005230 34730508 35005824 54312741 35116208 44955778 38061734 39177138 67687937 40287381 53541754 55074511 42862982 63602318 78982685 47147568 62444018 49345167 48274161 49737640 52664080 80142207 54127559 57272110 64409797 69121438 73067558 70122032 73177942 74293346 118859078 78349115 87451299 95527062 83150363 132476674 90010550 91137143 95421729 145594381 96885208 97619328 98011801 100938241 102401720 106791639 111399669 154420347 121681907 133531235 142188996 144415378 167007240 147471288 196359970 165800414 161499478 173160913 252039675 174287506 185432279 334660391 193041057 259511279 352977916 203676847 500449204 198950042 266097285 209193359 253588665 233081576 294842820 399510963 310215792 347448419 513248833 370692837 308970766 642291239 327299892 335786984 358593192 359719785 367328563 394625638 503256849 402234416 402626889 412870206 469774132 560940105 908388524 442274935 462782024 486670241 527924396 656419185 619186558 772997816 727048348 636270658 949452265 644757750 663086876 687019677 1310622940 718312977 928268668 769955452 807495844 815497095 804861305 1021813447 855145141 905056959 928945176 1723885619 970199331 1191011272 1014594637 1172682146 1255457216 1615288345 1452253594 1281028408 1299357534 1307844626 1331777427 1625100593 1405332654 1646581645 1488268429 1574816757 1577451296 2896316753 1834002135 1660006446 1760202100 3337653396 2991783873 2554814750 2787625963 3978637235 2187276783 2270051853 2428139362 4984235041 2588873034 3239334789 4520363197 4132266046 3148274875 3051914299 2893601083 2982783950 6041875958 3063085186 5321966152 4214821196 3420208546 8935477041 3847283229 3947478883 4457328636 4615416145 4698191215 5080877866 4776149817 4858924887 5017012396 5321740445 5482474117 5571656984 5876385033 5945515382 7350929719 6841079966 5956686269 6045869136 6402992496 10499204594 6483293732 7267491775 7367687429 7794762112 8304611865 12922586703 8404807519 9072744781 9313607360 21327394222 9939802753 9635074704 10180665332 10338752841 12359678765 11054131101 11448042017 14281192552 11902201651 12002555405 16295439110 12439980001 13670484271 13770679925 13750785507 14635179204 15062253887 16099373977 23413809866 18485277197 21942358158 21075300186 21387844770 18948682064 19574877457 28425079950 23305558975 20519418173 29933319214 22502173118 22956332752 23350243668 23904757056 44425543854 25753340912 26110464272 26190765508 27421269778 32255957122 39513183843 29697433091 34637131344 34584651174 37433959261 38060154654 60827896852 60588484029 38523559521 67381876606 40094295630 83544816781 43021591291 46861089808 113478135995 50015221328 46306576420 47255000724 50095522564 66840608296 51944106420 53531734050 58446722630 57118702869 61953390213 144372713633 64282084265 77606242465 72018610435 78154450284 138434139317 78617855151 100392823858 85384649329 188449360645 103979792677 123962716855 113701698104 211213321929 116936130860 93561577144 96402098984 99199107144 128249972848 105475840470 109062809289 129137313304 126235474478 133972000648 201155923739 141888326730 136300694700 149624852900 217328954718 193954401002 172179432295 164002504480 178946226473 396275181191 189963676128 300429405143 199037417614 436730099843 192760684288 234613153774 195601206128 331015252758 204674947614 214538649759 231711314948 235298283767 255372787782 285925547600 568454613486 278189021430 291513179630 427373838062 586388040540 336181936775 357956905482 564114569030 413559380247 382724360416 385564882256 489985941556 1132569182516 517636862548 388361890416 622975044190 469911437541 400276153742 587399308030 490600495214 446249964707 467009598715 569702201060 541298335382 577438727230 743521787738 773926772672 761424617171 1140611906738 694138842257 846526118449 740681265898 1077999803244 768289242672 771086250832 1077385249586 834611855123 788638044158 965800617646 858273327957 1292776083156 1164838035260 1351365499902 1279238539372 1060302696274 913259563422 1366076771388 1754441538531 1309587578054 1423964845679 1434820108155 1455563459428 1462428084929 1559724294990 1607398405679 1587207384347 2122451750734 1539375493504 1894914551397 1684345814254 2282238173636 1623249899281 1879060181068 1973562259696 2293093436112 2078097598682 2192498102794 2916985983733 3648314945024 2222847141476 2279336334810 4505085315112 3617473092186 2744407686209 2879528305107 2890383567583 2994938952932 3001803578433 4811900535130 3512937753200 3126582877851 3307595713535 3907192955730 3657908073950 4485591538906 7033775833581 6309399291968 3852622440764 4975365838129 8623680783153 6514741331633 7977169416562 5927651279834 4502183476286 7556308221339 6197979281118 5634791253792 11618619736085 11750263661004 5769911872690 5885322520515 5996742531365 6128386456284 6434178591386 6639520631051 6965503787485 7565101029680 9541984209522 9427819946640 13441630741854 8354805917050 9477549314415 8827988278893 10387505996801 10136974730078 10429834756120 14483192373334 10272095348976 11631533785157 13999279621066 11404703126482 11520113774307 11655234393205 11766654404055 11882065051880 13561843561045 15793492066378 13073699222437 13605024418536 18159634405358 17896790126572 17837196378656 21949948530427 17782625863690 20483222672098 17182794195943 21359614366295 20659601345777 23286768178362 20409070079054 22085069149325 28431729754334 21676798475458 22924816900789 23059937519687 23171357530537 23175348167512 23421888797260 23648719455935 24955764274317 30744637756988 35019990574599 39142240229985 38819235751135 48377653071577 34965420059633 35619822242346 60904304900460 37591864274997 37666016868041 37842395541720 41068671424831 71799541868837))))))
