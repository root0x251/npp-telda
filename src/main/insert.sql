--insert into region_info (
--    "region_name",
--    region_short_name,
--    flag_url)
--values ('flag url', 'region name', 'A');

insert into region_info (
    region_name,
    region_short_name,
    flag_url)
values ('flag url', 'region name', 'A') ON CONFLICT (region_short_name) DO NOTHING;



