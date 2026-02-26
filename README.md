# MyBuddy 项目脚手架

本仓库包含：
- `android/`：Kotlin + Jetpack Compose 客户端框架（个人页/学伴页/商城页）。
- `backend/`：Spring Boot + Java 后端框架（任务、学伴、商城、用户、OSS上传）。
- `database/schema.sql`：MySQL 数据库表结构。
- `docs/api-design.md`：RESTful API 设计文档。

## 功能映射
- 个人页：今日任务、分类、完成勾选、deadline展示、历史/未来任务扩展点、拍照上传识别扩展点。
- 学伴页：邀请码加入、计划查看、聊天（文字/表情模型）。
- 商城页：个人/学伴可见商品，积分兑换。

## 关键技术
- Android: Compose + Navigation。
- Backend: Spring Boot Web/JPA/Security + MySQL + OSS SDK。
- 日志: 当前以文件日志为基础，后续可接入阿里云日志服务 SLS。
