CREATE TABLE users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  phone VARCHAR(20) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  points INT NOT NULL DEFAULT 0,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL
);

CREATE TABLE tasks (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  content VARCHAR(500) NOT NULL,
  category VARCHAR(20) NOT NULL,
  status VARCHAR(20) NOT NULL,
  task_date DATE,
  deadline DATETIME,
  display_order INT NOT NULL DEFAULT 0,
  reward_points INT NOT NULL DEFAULT 0,
  image_url VARCHAR(500),
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  CONSTRAINT fk_tasks_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE study_buddy_relationships (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  buddy_id BIGINT NOT NULL,
  invite_code VARCHAR(64) NOT NULL UNIQUE,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  CONSTRAINT fk_rel_user FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT fk_rel_buddy FOREIGN KEY (buddy_id) REFERENCES users(id)
);

CREATE TABLE chat_messages (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  relationship_id BIGINT NOT NULL,
  sender_id BIGINT NOT NULL,
  type VARCHAR(20) NOT NULL,
  content VARCHAR(1000) NOT NULL,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  CONSTRAINT fk_chat_rel FOREIGN KEY (relationship_id) REFERENCES study_buddy_relationships(id),
  CONSTRAINT fk_chat_sender FOREIGN KEY (sender_id) REFERENCES users(id)
);

CREATE TABLE shop_items (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  owner_id BIGINT NOT NULL,
  visible_to_buddy_id BIGINT,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(500),
  point_cost INT NOT NULL,
  image_url VARCHAR(500),
  active TINYINT(1) NOT NULL DEFAULT 1,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  CONSTRAINT fk_item_owner FOREIGN KEY (owner_id) REFERENCES users(id),
  CONSTRAINT fk_item_visible FOREIGN KEY (visible_to_buddy_id) REFERENCES users(id)
);

CREATE TABLE point_transactions (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  delta INT NOT NULL,
  reason VARCHAR(255) NOT NULL,
  ref_id BIGINT,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  CONSTRAINT fk_tx_user FOREIGN KEY (user_id) REFERENCES users(id)
);
