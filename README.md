Runtime instructions :

Please run the CodeSearchApplication.java to get the results.


Application executes uses basic data structures to form Inverted Index and produces results for most cases in < 1 ms. And observed worst case 10 ms.
It has 3 major parts.

1) Read file data (before search starts);
-----------------------------------------
Absorb all the readable files in the folder structure recursively and maintain a list of line in for each of the file.
i.e., maintain a Map where key is <Filename> and value is the List <Lines> in the file.
This <Map> is then passed onto Index manager to populate the InvertedIndex for each of word in them.

2) InvertedIndex population (before search starts):
---------------------------------------------------
Form a basic Inverted Index for all the words in the files list.
Input: Map <Filename, List <lines>>
Inverted Index is a map with Key: "word" and value: List<Index>, where Index struct holds - the filename and arraylist index of the line which has the word.

3) Search :
-----------
Search gets the word from the InvertedIndex at O(1) and iterates thro the List of the Index and gets their respective lines in the FileData Map at again O(1) & O(1) time complexity.

Average observerd response time : 1 ms





Sample Output with total time in Milliseconds, Number of lines with words and the search result
-----------------------------------------------------------------------------------------------

Enter word to search (Type EXIT to quit) :
activedefrag
Total time in ms : 1
Total number of lines with word : 11
[ { "fileName": "memefficiency.tcl", "line": "            r config set activedefrag no" },  { "fileName": "memefficiency.tcl", "line": "            r config set activedefrag yes" },  { "fileName": "memefficiency.tcl", "line": "            r config set activedefrag no" },  { "fileName": "memefficiency.tcl", "line": "            r config set activedefrag yes" },  { "fileName": "config.c", "line": "        } else if (!strcasecmp(argv[0],"activedefrag") && argc == 2) {" },  { "fileName": "config.c", "line": "      "activedefrag",server.active_defrag_enabled) {" },  { "fileName": "config.c", "line": "    config_get_bool_field("activedefrag", server.active_defrag_enabled);" },  { "fileName": "config.c", "line": "    rewriteConfigYesNoOption(state,"activedefrag",server.active_defrag_enabled,CONFIG_DEFAULT_ACTIVE_DEFRAG);" },  { "fileName": "object.c", "line": "            s = sdscatprintf(s," * High allocator fragmentation: This instance has an allocator external fragmentation greater than 1.1. This problem is usually due either to a large peak memory (check if there is a peak memory entry above in the report) or may result from a workload that causes the allocator to fragment memory a lot. You can try enabling 'activedefrag' config option.\n\n");" },  { "fileName": "redis.conf", "line": "#    needed with the command "CONFIG SET activedefrag yes"." },  { "fileName": "redis.conf", "line": "# activedefrag yes" }]


Enter word to search (Type EXIT to quit) :
client-reconfig-script
Total time in ms : 0
Total number of lines with word : 10
[ { "fileName": "sentinel.c", "line": "   } else if (!strcasecmp(argv[0],"client-reconfig-script") && argc == 3) {" },  { "fileName": "sentinel.c", "line": "        /* client-reconfig-script <name> <path> */" },  { "fileName": "sentinel.c", "line": "        /* sentinel client-reconfig-script */" },  { "fileName": "sentinel.c", "line": "                "sentinel client-reconfig-script %s %s"," },  { "fileName": "sentinel.c", "line": "            addReplyBulkCString(c,"client-reconfig-script");" },  { "fileName": "sentinel.c", "line": "       } else if (!strcasecmp(option,"client-reconfig-script")) {" },  { "fileName": "sentinel.c", "line": "            /* client-reconfig-script <path> */" },  { "fileName": "sentinel.conf", "line": "# sentinel client-reconfig-script <master-name> <script-path>" },  { "fileName": "sentinel.conf", "line": "# sentinel client-reconfig-script mymaster /var/redis/reconfig.sh" },  { "fileName": "sentinel.conf", "line": "# sentinel client-reconfig-script mymaster /var/redis/reconfig.sh" }]
