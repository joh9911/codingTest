//data class SubComment(val id: String, val userName: String, val commentId: String)
//data class Comment(val id: String, val userName: String, val articleId: String)
//data class Article(val id: String, val userName: String)
//data class User(val name: String, val articleAlarmState: Boolean = true, val commentAlarmState: Boolean = true, val alarmCount:Int = 0)
//
//fun main(){
//
//    // "A", "E", "F"
//    // {"A", "ALARM", "ARTICLE"}
//    // {"E", "ALARM", "COMMENT"}
//    // {"F", "ARTICLE", "ARTICLE_ID"}
//    // {"A", "COMMENT", "COMMENT_ID", "ARTICLE_ID"}
//    // {"F", "SUB_COMMENT", "SUB_COMMENT_ID", "COMMENT_ID"}
//
//
//    fun solutions(members: Array<String>, logs: Array<Array<String>>): IntArray{
//        val answer = IntArray(members.size)
//
//        val userList = mutableListOf<User>()
//        val articleList = mutableListOf<Article>()
//        val commentList = mutableListOf<Comment>()
//        val subCommentList = mutableListOf<SubComment>()
//
//        for (index in members.indices){
//            userList.add(User(members[index]))
//        }
//
//        for (log in logs){
//            val logUserName = log.first()
//            val category = log[1]
//
//            if (category == "ALARM"){
//                val alarmType = log[2]
//                toggleState(userList, alarmType, logUserName)
//            }
//
//            else{
//                when (category){
//                    "ARTICLE" -> {
//                        saveArticleDatabase(log, articleList)
//                        sendArticleAlarmToUser(log, userList, articleList)
//                    }
//                    "COMMENT" -> {
//                        saveCommentDatabase(log,commentList)
//                        val commentCount = getCommentCount(log,commentList, subCommentList)
//                        if (commentCount >= 6){
//                            sendCommentAlarmToUser(log, userList, articleList, commentList)
//                            sendSubCommentAlarmToUserByCommentId(log, userList, commentList, subCommentList)
//                        }
//                        else{
//                            sendCommentAlarmToUser(log, userList, articleList, commentList)
//                        }
//                    }
//                    "SUB_COMMENT" -> {
//                        saveSubCommentDatabase(log, subCommentList)
//                        val commentCount = getCommentCount(log, commentList, subCommentList)
//                        if (commentCount >= 6){
//                            sendCommentAlarmToUser(log, userList, articleList, commentList)
//                            sendSubCommentAlarmToUserByCommentId(log, userList, commentList, subCommentList)
//                        }
//                        else{
//                            sendSubCommentAlarmToUser(log, userList, commentList, subCommentList)
//                        }
//                    }
//                }
//            }
//        }
//        return answer
//    }
//}
//
//fun saveArticleDatabase(log: Array<String>, articleList: MutableList<Article>){
//    val articleUserName = log.first()
//    val articleId = log[2]
//
//    articleList.add(Article(articleId, articleUserName))
//}
//
//
///**
// * 게시물 생성 시, 알람 설정이 되어있는 모든 유저에게 알람 전송
// */
//fun sendArticleAlarmToUser(log: Array<String>, userList: MutableList<User>, articleList: MutableList<Article>){
//    val articleUserName = log.first()
//    val articleId = log[2]
//
//    for (i in articleList.indices){
//        val article = articleList[i]
//
//        if (article.id == articleId){
//            for (j in userList.indices){
//                val user = userList[j]
//
//                if (user.name == article.userName && user.articleAlarmState){
//                    if (user.name == articleUserName) continue
//                    userList[j] = user.copy(alarmCount = user.alarmCount + 1)
//                }
//            }
//        }
//    }
//}
//
//fun saveCommentDatabase(log: Array<String>, commentList: MutableList<Comment>){
//    val commentUserName = log.first()
//    val commentId = log[2]
//    val articleId = log[3]
//
//    commentList.add(Comment(commentId, commentUserName, articleId))
//}
//
//
///**
// * 게시물에 댓글 작성 시, 게시물을 작성한 유저와 게시물에 댓글을 작성한 유저들에게 알람 전송
// */
//fun sendCommentAlarmToUser(log: Array<String>, userList: MutableList<User>, articleList: MutableList<Article>, commentList: MutableList<Comment>){
//    val commentUserName = log.first()
//    val articleId = log[3]
//
//    val distinctCommentList = commentList.distinctBy { it.userName }
//    for (i in distinctCommentList.indices){
//        val comment = distinctCommentList[i]
//
//        if (comment.articleId == articleId){
//            for (j in userList.indices){
//                val user = userList[j]
//
//                if (user.name == comment.userName && user.commentAlarmState){
//                    if (user.name == commentUserName) continue
//                    userList[j] = user.copy(alarmCount = user.alarmCount + 1)
//                }
//            }
//        }
//    }
//
//    for (i in articleList.indices){
//        val article = articleList[i]
//
//        if (articleId == article.id){
//            for (j in userList.indices){
//                val user = userList[j]
//
//                if (user.name == article.userName && user.commentAlarmState){
//                    if (user.name == commentUserName) continue
//                    userList[j] = user.copy(alarmCount = user.alarmCount + 1)
//                }
//            }
//        }
//    }
//}
//
//fun saveSubCommentDatabase(log: Array<String>, subCommentList: MutableList<SubComment>){
//    val subCommentUserName = log.first()
//    val subCommentId = log[2]
//    val commentId = log[3]
//
//    subCommentList.add(SubComment(subCommentId, subCommentUserName, commentId))
//}
//
//
///**
// * 대댓글을 달았을 때, 댓글을 작성한 유저와 해당 댓글의 대댓글을 작성한 유저들에게 알람 전송
// */
//fun sendSubCommentAlarmToUser(log: Array<String>, userList: MutableList<User>, commentList: MutableList<Comment>, subCommentList: MutableList<SubComment>){
//    val subCommentUserName = log.first()
//    val commentId = log[3]
//    val distinctCommentList = commentList.distinctBy { it.userName }
//    val distinctSubCommentList = subCommentList.distinctBy { it.userName }
//
//    for (i in distinctCommentList.indices){
//        val comment = distinctCommentList[i]
//
//        if (comment.id == commentId){
//            val articleId = comment.articleId
//
//            for (j in distinctCommentList.indices){
//                val comment = commentList[j]
//
//                if (comment.articleId == articleId){
//                    for (k in userList.indices){
//                        val user = userList[k]
//
//                        if (user.name == comment.userName){
//                            if (user.name == subCommentUserName) continue
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    for (i in distinctSubCommentList.indices){
//        val subComment = distinctSubCommentList[i]
//
//        if (subComment.commentId == commentId){
//            for (j in userList.indices){
//                val user = userList[j]
//
//                if (user.name == subComment.userName && user.commentAlarmState){
//                    if (user.name == subCommentUserName) continue
//                    userList[j] = user.copy(alarmCount = user.alarmCount + 1)
//                }
//            }
//        }
//    }
//
//    for (i in distinctCommentList.indices){
//        val comment = distinctCommentList[i]
//
//        if (comment.id == commentId){
//            for (j in userList.indices){
//                val user = userList[j]
//
//                if (user.name == comment.userName && user.commentAlarmState){
//                    if (user.name == subCommentUserName) continue
//                    userList[j] = user.copy(alarmCount = user.alarmCount + 1)
//
//                }
//            }
//        }
//    }
//}
//
//
///**
// * 인기글에 대댓글이 달렸을 때, 게시물을 작성한 유저, 댓글을 작성한 유저, 대댓글을 작성한 유저 모두에게 알람을 전송하는 매소드
// */
//fun sendSubCommentAlarmToUserByCommentId(log: Array<String>, userList: MutableList<User>, articleList: MutableList<Article>, commentList: MutableList<Comment>, subCommentList: MutableList<SubComment>){
//    val subCommentUserName = log.first()
//    val commentId = log[3]
//    var articleId = ""
//
//    val distinctCommentList = commentList.distinctBy { it.userName }
//    val distinctSubCommentList = subCommentList.distinctBy { it.userName }
//
//    // 게시글 쓴 사람 알람
//    for (i in distinctSubCommentList.indices){
//        val subComment = distinctSubCommentList[i]
//
//        for (j in commentList.indices){
//            val comment = commentList[j]
//
//            if (comment.id == subComment.commentId){
//
//                for (k in articleList.indices){
//                    val article = articleList[k]
//
//                    if (comment.articleId == article.id){
//                        articleId = article.id
//
//                        for (l in userList.indices){
//                            val user = userList[l]
//
//                            if (user.name == article.userName){
//                                if (user.name == subCommentUserName) continue
//                                userList[j] = user.copy(alarmCount = user.alarmCount + 1)
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    // 대댓글 단 유저들 알람
//    for (i in distinctSubCommentList.indices){
//        val subComment = distinctSubCommentList[i]
//
//        if (subComment.commentId == commentId){
//            for (j in userList.indices){
//                val user = userList[j]
//
//                if (user.name == subComment.userName){
//                    if (user.name == subCommentUserName) continue
//                    userList[j] = user.copy(alarmCount = user.alarmCount + 1)
//                }
//            }
//        }
//    }
//
//    // 댓글 단 유저들 알람
//    for (i in distinctCommentList.indices){
//        val comment = distinctCommentList[i]
//
//        if (comment.articleId == articleId){
//            for (j in userList.indices){
//                val user = userList[j]
//
//                if (user.name == comment.userName && user.commentAlarmState){
//                    if (user.name == commentUserName) continue
//                    userList[j] = user.copy(alarmCount = user.alarmCount + 1)
//                }
//            }
//        }
//    }
//}
//
///**
// * 게시물의 전체 댓글 개수를 가져오는 매소드
// */
//fun getCommentCount(log: Array<String>, commentList: MutableList<Comment>, subCommentList: MutableList<SubComment>): Int {
//    val category = log[1]
//    val commentId = when(category){
//        "COMMENT" -> log[2]
//        "SUB_COMMENT" -> log[3]
//        else -> 0
//    }
//    var count = 0
//
//    for (i in subCommentList.indices){
//        val subComment = subCommentList[i]
//
//        if (commentId == subComment.commentId){
//            count ++
//
//        }
//    }
//
//    for (i in commentList.indices){
//        val comment = commentList[i]
//
//        if (comment.id == commentId){
//            count ++
//        }
//    }
//    return count
//}
//
//
//
//fun toggleState(userList: MutableList<User>, alarmType: String, userName: String){
//    for (index in userList.indices){
//        val user = userList[index]
//        if (user.name == userName){
//            when (alarmType){
//                "ARTICLE" -> userList[index] = user.copy(articleAlarmState = !user.articleAlarmState)
//                "COMMENT" -> userList[index] = user.copy(commentAlarmState = !user.commentAlarmState)
//            }
//        }
//    }
//}