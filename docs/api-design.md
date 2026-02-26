# MyBuddy REST API 设计

## 用户模块
- `POST /api/users/register`：手机号 + 密码注册。

## 任务模块
- `POST /api/tasks`：创建任务（支持分类、deadline、积分）。
- `GET /api/tasks?userId=&date=`：获取指定日期任务。
- `GET /api/tasks/deadlines?userId=`：获取deadline任务。
- `PATCH /api/tasks/reorder`：批量更新任务排序（拖拽后提交ID顺序）。
- `PATCH /api/tasks/{taskId}/done`：标记任务完成。
- `POST /api/tasks/upload`：上传任务图片到OSS并返回AI识别文本。

## 学伴模块
- `POST /api/buddies/join`：通过邀请码加入自习室。
- `GET /api/buddies?userId=`：查询学伴关系。
- `POST /api/buddies/{relationshipId}/messages`：发送消息（文本/表情）。
- `GET /api/buddies/{relationshipId}/messages`：查询聊天记录。

## 商城模块
- `POST /api/shop/items`：用户上架商品（可指定仅学伴可见）。
- `GET /api/shop/items?userId=`：查询个人/学伴可见商品。
- `POST /api/shop/redeem`：积分兑换商品。

## 非功能要求落地
- OSS：图片文件上传，DB中存URL。
- 阿里云日志服务：建议通过Logback Appender投递SLS（示例框架预留日志配置）。
- 推送：当前不实现，后续可接入FCM/厂商通道。
