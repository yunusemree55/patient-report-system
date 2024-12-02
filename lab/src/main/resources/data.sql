INSERT INTO statuses (name)
SELECT * FROM (VALUES 
    ('Active'),
    ('Passive')
) AS temp(name)
WHERE NOT EXISTS (SELECT 1 FROM statuses LIMIT 1);