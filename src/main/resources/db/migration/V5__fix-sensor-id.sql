SELECT setval('sensors_id_seq', COALESCE((SELECT MAX(id) FROM sensors), 0));
